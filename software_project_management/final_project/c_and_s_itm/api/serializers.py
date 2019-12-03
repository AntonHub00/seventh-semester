from rest_framework import serializers

from api.models import (Complaint, StudentComplaint, StaffComplaint,
                        ExternalRelatedComplaint)

class ComplaintSerializer(serializers.ModelSerializer):
    class Meta:
        model = Complaint
        fields = "__all__"

class StudentComplaintSerializer(serializers.ModelSerializer):
    complaint = ComplaintSerializer(required=True)

    class Meta:
        model = StudentComplaint
        fields = "__all__"

class StaffComplaintSerializer(serializers.ModelSerializer):
    complaint = ComplaintSerializer(required=True)

    class Meta:
        model = StaffComplaint
        fields = "__all__"

class ExternalRelatedComplaintSerializer(serializers.ModelSerializer):
    complaint = ComplaintSerializer(required=True)

    class Meta:
        model = ExternalRelatedComplaint
        fields = "__all__"
