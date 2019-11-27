from django.urls import path, include

from api.views import (ParadigmsList, ParadigmDetail, ParadigmFind,
                       LanguagesList, LanguageDetail, LanguageFindByParadigm,
                       LanguageFindByName)

urlpatterns = [

    # Paradigms
    path('paradigms/<int:pk>/', ParadigmDetail.as_view(), name='detailParadigm'),
    path('paradigms/<paradigm>/', ParadigmFind.as_view(), name='findParadigm'),
    path('paradigms/', ParadigmsList.as_view(), name='listParadigms'),

    # Languages
    path('languages/<int:pk>/', LanguageDetail.as_view(), name='detailLanguage'),
    path('languages/', LanguagesList.as_view(), name='listLanguages'),
    path('languages/by-paradigm/<language>/',
         LanguageFindByParadigm.as_view(), name='findLanguageByParadigm'),
    path('languages/by-name/<language>/',
         LanguageFindByName.as_view(), name='findLanguageByName'),
]
