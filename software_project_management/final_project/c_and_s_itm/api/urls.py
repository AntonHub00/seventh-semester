from django.urls import path, include
from api.views import (get_complaints, create_student_complaint,
                       create_staff_complaint,
                       create_external_related_complaint)

urlpatterns = [
    path('get-complaints/', get_complaints, name='api-get-complaints'),
    path('create-student-complaint/', create_student_complaint,
         name='api-create-student-complaint'),
    path('create-staff-complaint/', create_staff_complaint,
         name='api-create-staff-complaint'),
    path('create-external-related-complaint/',
         create_external_related_complaint,
         name='api-create-external-related-complaint'),
]
