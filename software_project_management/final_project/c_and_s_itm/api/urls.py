from django.urls import path, include
from api.views import (
    ComplaintAll,
    ComplaintSpecific,
    ComplaintByType,
    get_raw_complaints,
    create_student_complaint,
    create_staff_complaint,
    create_external_related_complaint,
)

urlpatterns = [
    # Retrieve all the fields and instances of all types of complaints
    path('complaints/', ComplaintAll.as_view(), name='api-complaint-all'),

    # Retrieve all the fields and instances of a specific type of complaint
    path('complaints/<complaint_type/', ComplaintByType.as_view(),
         name='api-complaint-by-type'),

    # Retrieve all the fields of a specific complaint (one instance)
    path('complaints/<complaint_type>/<int:pk>', ComplaintSpecific.as_view(),
         name='api-complaint-specific'),

    path('get-raw-complaints/', get_raw_complaints, name='api-get-raw-complaints'),

    path('create-student-complaint/', create_student_complaint,
         name='api-create-student-complaint'),

    path('create-staff-complaint/', create_staff_complaint,
         name='api-create-staff-complaint'),

    path('create-external-related-complaint/',
         create_external_related_complaint,
         name='api-create-external-related-complaint'),

]
