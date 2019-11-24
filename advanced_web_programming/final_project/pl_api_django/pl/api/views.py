from rest_framework.views import APIView
from rest_framework import generics
from rest_framework.response import Response
from rest_framework.parsers import JSONParser
from django.http import Http404
from api.models import Paradigm, Language
from api.serializers import ParadigmSerializer, LanguageSerializer


class ParadigmList(generics.ListCreateAPIView):
    queryset = Paradigm.objects.all()
    serializer_class = ParadigmSerializer


class ParadigmDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Paradigm.objects.all()
    serializer_class = ParadigmSerializer


class LanguageList(generics.ListCreateAPIView):
    queryset = Language.objects.all()
    serializer_class = LanguageSerializer


class LanguageDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Language.objects.all()
    serializer_class = LanguageSerializer
