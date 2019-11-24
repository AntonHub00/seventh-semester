from django.urls import path, include
from api.views import ParadigmList, ParadigmDetail, LanguageList, LanguageDetail

urlpatterns = [
    path('paradigms/<int:pk>/', ParadigmDetail.as_view()),
    path('paradigms/', ParadigmList.as_view()),
    path('languages/<int:pk>/', LanguageDetail.as_view()),
    path('languages/', LanguageList.as_view()),
]
