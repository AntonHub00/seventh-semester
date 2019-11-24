from django.db import models


class Paradigm(models.Model):
    name = models.CharField(max_length=50)

    def __str__(self):
        return self.name


class Language(models.Model):
    name = models.CharField(max_length=50)
    # Missing field to store blob or images
    description = models.TextField()
    firstAppeared = models.IntegerField()
    lastVersion = models.CharField(max_length=50)
    creator = models.CharField(max_length=50)
    paradigms = models.ManyToManyField(Paradigm)

    def __str__(self):
        return self.name
