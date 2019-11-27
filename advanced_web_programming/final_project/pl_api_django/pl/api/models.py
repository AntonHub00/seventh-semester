from django.db import models


class Paradigm(models.Model):
    """This class represents a paradigm Model"""

    name = models.CharField(max_length=50)

    def __str__(self):
        return self.name


class Language(models.Model):
    """This class represents a language Model"""

    name = models.CharField(max_length=50)
    image = models.TextField()
    description = models.TextField()
    firstAppeared = models.IntegerField()
    lastVersion = models.CharField(max_length=50)
    creator = models.CharField(max_length=50)
    paradigms = models.ManyToManyField(Paradigm)

    def __str__(self):
        return self.name
