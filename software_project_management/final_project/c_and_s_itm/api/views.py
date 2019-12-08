from api.models import (Complaint, StudentComplaint, StaffComplaint,
                        ExternalRelatedComplaint)
from api.serializers import (StudentComplaintSerializer,
                             StaffComplaintSerializer,
                             ExternalRelatedComplaintSerializer)

from django.contrib.auth.models import User
from django.shortcuts import get_object_or_404

from rest_framework.decorators import api_view, permission_classes
from rest_framework import permissions
from rest_framework.response import Response



@api_view(['GET'])
@permission_classes((permissions.AllowAny,))
def get_complaints(request):
    payload = {}

    students_complaints = StudentComplaint.objects.all()
    staff_complaints = StaffComplaint.objects.all()
    external_related_complaints = ExternalRelatedComplaint.objects.all()


    payload['students'] = StudentComplaintSerializer(students_complaints,
                                                     many=True).data
    payload['staff'] = StaffComplaintSerializer(staff_complaints,
                                                  many=True).data
    payload['extenal_related'] = ExternalRelatedComplaintSerializer(
        external_related_complaints,
        many=True).data

    return Response({'complaints' : payload})


@api_view(['GET'])
@permission_classes((permissions.AllowAny,))
def get_student_complaint(request, pk):
    student_complaint = get_object_or_404(StudentComplaint, complaint=pk)

    payload = StudentComplaintSerializer(student_complaint).data

    return Response({'complaint' : payload})


@api_view(['GET'])
@permission_classes((permissions.AllowAny,))
def get_staff_complaint(request, pk):
    staff_complaint = get_object_or_404(StaffComplaint, complaint=pk)

    payload = StaffComplaintSerializer(staff_complaint).data

    return Response({'complaint' : payload})


@api_view(['GET'])
@permission_classes((permissions.AllowAny,))
def get_external_related_complaint(request, pk):
    external_related_complaint = get_object_or_404(ExternalRelatedComplaint,
                                                   complaint=pk)

    payload = ExternalRelatedComplaintSerializer(external_related_complaint).data

    return Response({'complaint' : payload})


@api_view(['POST'])
@permission_classes((permissions.AllowAny,))
def create_student_complaint(request):
    # Assuming the data is validated in front-end

    general_complaint, created = Complaint.objects.get_or_create(
        name=request.data['name'],
        email=request.data['email'],
        phone=request.data['phone'],
        complaint_content=request.data['complaint_content']
    )

    if not created:
        return Response({'error' : 'There is already a complaint with this data'})

    student_complaint, created = StudentComplaint.objects.get_or_create(
        complaint=general_complaint,
        control_number=request.data['control_number'],
        career=request.data['career'],
        semester=request.data['semester'],
        group=request.data['group'],
        turn=request.data['turn'],
        classroom=request.data['classroom']
    )

    if not created:
        return Response({'error' : 'There is already a student complaint with this data'})

    return Response({'succes' : 'Student complaint created succesfully'})


@api_view(['POST'])
@permission_classes((permissions.AllowAny,))
def create_staff_complaint(request):
    # Assuming the data is validated in front-end

    general_complaint, created = Complaint.objects.get_or_create(
        name=request.data['name'],
        email=request.data['email'],
        phone=request.data['phone'],
        complaint_content=request.data['complaint_content']
    )

    if not created:
        return Response({'error' : 'There is already a complaint with this data'})

    staff_complaint, created = StaffComplaint.objects.get_or_create(
        complaint=general_complaint,
        rfc=request.data['rfc'],
        department=request.data['department']
    )

    if not created:
        return Response({'error' : 'There is already a staff complaint with this data'})

    return Response({'succes' : 'Staff complaint created succesfully'})

@api_view(['POST'])
@permission_classes((permissions.AllowAny,))
def create_external_related_complaint(request):
    # Assuming the data is validated in front-end

    general_complaint, created = Complaint.objects.get_or_create(
        name=request.data['name'],
        email=request.data['email'],
        phone=request.data['phone'],
        complaint_content=request.data['complaint_content']
    )

    if not created:
        return Response({'error' : 'There is already a complaint with this data'})

    external_related_complaint, created = ExternalRelatedComplaint.objects.get_or_create(
        complaint=general_complaint,
        relation=request.data['relation']
    )

    if not created:
        return Response({'error' : 'There is already a external related complaint with this data'})

    return Response({'succes' : 'Staff complaint created succesfully'})
