from rest_framework.views import APIView
from rest_framework import generics
from rest_framework.response import Response
from rest_framework.parsers import JSONParser
from django.http import Http404

from api.models import Paradigm, Language
from api.serializers import ParadigmSerializer, LanguageSerializer


class ParadigmsList(generics.ListCreateAPIView):
    """This class shows all the paradigms available. Returns all ids
    and names"""

    queryset = Paradigm.objects.all()
    serializer_class = ParadigmSerializer


class ParadigmDetail(generics.RetrieveUpdateDestroyAPIView):
    """This class shows the details of a specific paradigm base on the
    id provided in the url. Returns id and name"""
    queryset = Paradigm.objects.all()
    serializer_class = ParadigmSerializer


class LanguagesList(generics.ListCreateAPIView):
    """This class shows all the languages available. Returns all ids, names,
    descriptions, firstAppeareds, lastVersions, creators and the lists with the
    only paradigm names asociated with the languages"""

    queryset = Language.objects.all()
    serializer_class = LanguageSerializer


class LanguageDetail(generics.RetrieveUpdateDestroyAPIView):
    """This class shows the details of a specific language base on the
    id provided in the url. Returns id, name, description, firstAppeared,
    lastVersion, creator and the list with only paradigm names asociated with
    the language"""

    queryset = Language.objects.all()
    serializer_class = LanguageSerializer
