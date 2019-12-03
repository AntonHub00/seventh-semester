from django.db import models


class Complaint(models.Model):
    """This a model class which represents a general complaint"""

    name = models.CharField(max_length=100, null=False, blank=False) # To split
    email = models.EmailField(null=False, blank=False) # To split
    phone = models.CharField(max_length=10,null=False, blank=False) # To split
    date = models.DateField(auto_now=True) # To split
    complaint_content = models.TextField(null=False, blank=False) # To split

    def __str__(self):
        return f"{self.name}'s general complaint"


class StudentComplaint(models.Model):
    """This a model class which represents a student complaint"""

    complaint = models.OneToOneField(Complaint, on_delete=models.CASCADE,
                                     related_name='student_complaint',
                                     primary_key= True)
    control_number = models.CharField(max_length=10, null=False, blank=False)
    career = models.CharField(max_length=50, null=False, blank=False)
    semester = models.CharField(max_length=2, null=False, blank=False)
    group = models.CharField(max_length=10, null=False, blank=False)
    turn = models.CharField(max_length=11, null=False, blank=False)
    classroom = models.CharField(max_length=10, null=False, blank=False)

    def __str__(self):
        return f"{self.complaint.name}'s student complaint"


class StaffComplaint(models.Model):
    """This a model class which represents a staff complaint"""

    complaint = models.OneToOneField(Complaint, on_delete=models.CASCADE,
                                     related_name='staff_complaint',
                                     primary_key=True)
    rfc = models.CharField(max_length=13, null=False, blank=False)
    department = models.CharField(max_length=100, null=False, blank=False)

    def __str__(self):
        return f"{self.complaint.name}'s staff complaint"


class ExternalRelatedComplaint(models.Model):
    """This a model class which represents a external related complaint"""

    complaint = models.OneToOneField(Complaint, on_delete=models.CASCADE,
                                     related_name='external_related_complaint',
                                     primary_key=True)
    relation = models.CharField(max_length=100, null=False, blank=False)

    def __str__(self):
        return f"{self.complaint.name}'s external related complaint"
