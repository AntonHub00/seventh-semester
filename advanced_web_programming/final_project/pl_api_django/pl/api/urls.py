from django.urls import path, include

from api.views import ParadigmsList, ParadigmDetail, LanguagesList, LanguageDetail

urlpatterns = [
    path('paradigms/<int:pk>/', ParadigmDetail.as_view(), name='detailParadigm'),
    path('paradigms/', ParadigmsList.as_view(), name='listParadigms'),
    path('languages/<int:pk>/', LanguageDetail.as_view(), name='detailLanguage'),
    path('languages/', LanguagesList.as_view(), name='listLanguages'),
]
