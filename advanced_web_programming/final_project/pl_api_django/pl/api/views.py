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


class ParadigmFind(generics.ListAPIView):
    """This class filters paradigms by name"""

    serializer_class = ParadigmSerializer

    def get_queryset(self):
        if 'paradigm' in self.kwargs:
            return Paradigm.objects.filter(name__contains=self.kwargs['paradigm'])


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


class LanguageFindByParadigm(generics.ListAPIView):
    """This class filters languages by paradigm"""

    serializer_class = LanguageSerializer

    def get_queryset(self):
        if 'language' in self.kwargs:
            return Language.objects.filter(paradigms__name__contains=self.kwargs['language'])


class LanguageFindByName(generics.ListAPIView):
    """This class filters languages by paradigm"""

    serializer_class = LanguageSerializer

    def get_queryset(self):
        if 'language' in self.kwargs:
            return Language.objects.filter(name__contains=self.kwargs['language'])
