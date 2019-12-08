from api.models import (Complaint, StudentComplaint, StaffComplaint,
                        ExternalRelatedComplaint)
from api.serializers import (ComplaintSerializer,
                             StudentComplaintSerializer,
                             StaffComplaintSerializer,
                             ExternalRelatedComplaintSerializer)

from django.contrib.auth.models import User
from django.shortcuts import get_object_or_404

from rest_framework import status
from rest_framework.decorators import api_view, permission_classes
from rest_framework.views import APIView
from rest_framework import permissions
from rest_framework.response import Response


def get_specific_object(complaint_type, pk):
    if complaint_type not in ['student', 'staff', 'external-related']:
        return Response({'error': "only 'student', 'staff' and 'external-related'"
                         ' are available in the url'},
                        status=status.HTTP_404_NOT_FOUND)

    if complaint_type == 'student':
        return get_object_or_404(StudentComplaint, complaint=pk)
    elif complaint_type == 'staff':
        return get_object_or_404(StaffComplaint, complaint=pk)
    else:
        return get_object_or_404(ExternalRelatedComplaint, complaint=pk)


class ComplaintAllOfAllTypes(APIView):
    def get(self, request):
        payload = {}

        student_complaints = StudentComplaint.objects.all()
        staff_complaints = StaffComplaint.objects.all()
        external_related_complaints = ExternalRelatedComplaint.objects.all()

        payload['students'] = StudentComplaintSerializer(student_complaints,
                                                         many=True).data
        payload['staff'] = StaffComplaintSerializer(staff_complaints,
                                                    many=True).data
        payload['extenal_related'] = ExternalRelatedComplaintSerializer(
            external_related_complaints,
            many=True).data

        return Response({'complaints' : payload})


class ComplaintGetCreateOneType(APIView):
    def get(self, request, complaint_type):
        payload = {}

        if complaint_type not in ['student', 'staff', 'external-related']:
            return Response({'error': "only 'student', 'staff' and 'external-related'"
                             ' are available in the url'},
                            status=status.HTTP_404_NOT_FOUND)

        if complaint_type == 'student':
            student_complaints = StudentComplaint.objects.all()
            payload = StudentComplaintSerializer(student_complaints,
                                                 many=True).data
        elif complaint_type == 'staff':
            staff_complaints = StaffComplaint.objects.all()
            payload = StaffComplaintSerializer(staff_complaints,many=True).data
        else:
            enternal_related_complaints = ExternalRelatedComplaint.objects.all()
            payload = ExternalRelatedComplaintSerializer(external_related_complaints,
                                                         many=True).data

        return Response(payload)

    def post(self, request, complaint_type):
        pass


class ComplaintAllOfOneType(APIView):
    def get(self, request, complaint_type, pk):
        payload = {}

        if complaint_type == 'student':
            payload = StudentComplaintSerializer(get_specific_object(complaint_type,
                                                                 pk)).data
        elif complaint_type == 'staff':
            payload = StaffComplaintSerializer(get_specific_object(complaint_type,
                                                               pk)).data
        else:
            payload = ExternalRelatedComplaintSerializer(get_specific_object(complaint_type,
                                                                         pk)).data

        return Response(payload)


class ComplaintListAllRaw(APIView):
    def get(self, request):
        general_complaints = Complaint.objects.all()
        payload = ComplaintSerializer(general_complaints, many=True)
        return Response({'raw_complaints' : payload})


class ComplaintRaw(APIView):
    pass


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
