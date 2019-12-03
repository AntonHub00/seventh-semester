from django.contrib import admin
from .models import (Complaint, StudentComplaint, StaffComplaint,
                     ExternalRelatedComplaint)

admin.site.register(Complaint)
admin.site.register(StudentComplaint)
admin.site.register(StaffComplaint)
admin.site.register(ExternalRelatedComplaint)
