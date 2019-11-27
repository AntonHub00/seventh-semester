from rest_framework import serializers

from api.models import Paradigm, Language


class ParadigmSerializer(serializers.ModelSerializer):
    """This class serializes the Paradigm model"""
    class Meta:
        model = Paradigm
        fields = ['id', 'name']
        read_only_fields = ['id']


class ParadigmListSerializer(serializers.ModelSerializer):
    """This serializer is created to help to render only the paradigms names in the
    language serializer"""

    class Meta:
        model = Paradigm
        fields = ['id', 'name']

    def to_representation(self, value):
        return value.name

    def to_internal_value(self, data):
        return data


class LanguageSerializer(serializers.ModelSerializer):
    """This class serializes the Language model and add the special behavior in
    create or update data (POST, PUT, PATCH) for this serializer (due to
    "paradigms" many to many field)"""

    paradigms = ParadigmListSerializer(many=True)

    class Meta:
        model = Language
        fields = ['id', 'name', 'description', 'firstAppeared', 'lastVersion',
                  'creator', 'paradigms']
        read_only_fields = ['id']

    def create(self, validated_data):
        paradigms = validated_data.pop('paradigms')
        language = Language.objects.create(**validated_data)
        language.paradigms.set(paradigms)

        return language

    def update(self, instance, validated_data):
        instance.name = validated_data.get('name', instance.name)
        instance.creator = validated_data.get('creator', instance.creator)
        instance.description = validated_data.get(
            'description', instance.description)
        instance.firstAppeared = validated_data.get(
            'firstAppeared', instance.firstAppeared)
        instance.lastVersion = validated_data.get(
            'lastVersion', instance.lastVersion)

        # Should be this way in order to update "paradigms" many to many field
        # (validate_data['paradimgs'] is a list of paradigm objects)
        if 'paradigms' in validated_data:
            instance.paradigms.set(validated_data['paradigms'])

        instance.save()

        return instance
