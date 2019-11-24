from rest_framework import serializers
from api.models import Paradigm, Language


class ParadigmSerializer(serializers.ModelSerializer):
    class Meta:
        model = Paradigm
        fields = ['id', 'name']
        read_only_fields = ['id']

    def create(self, validated_data):
        return Paradigm.objects.create(**validated_data)

    def update(self, instance, validated_data):
        instance.name = validated_data.get('name', instance.name)
        instance.save()
        return instance

    def to_representation(self, value):
        return value.name

    def to_internal_value(self, data):
        return data


class ParadigmListSerializer(serializers.ModelSerializer):
    class Meta:
        model = Paradigm
        fields = ['name']


class LanguageSerializer(serializers.ModelSerializer):
    paradigms = ParadigmSerializer(many=True)

    class Meta:
        model = Language
        fields = ['id', 'name', 'description',
                  'firstAppeared', 'lastVersion', 'creator', 'paradigms']
        read_only_fields = ['id']

    def create(self, validated_data):
        paradigms = validated_data.pop('paradigms')
        language = Language.objects.create(**validated_data)
        language.paradigms.set(paradigms)

        return language

    def update(self, instance, validated_data):
        # paradigms = validated_data.pop('paradigms')
        instance.name = validated_data['name']
        instance.creator = validated_data['creator']
        instance.description = validated_data['description']
        instance.firstAppeared = validated_data['firstAppeared']
        instance.lastVersion = validated_data['lastVersion']

        # Should be this way in order to update many to many field
        instance.paradigms.set(validated_data['paradigms'])

        instance.save()

        return instance
