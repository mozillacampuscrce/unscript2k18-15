from django.conf.urls import url
from django.urls import path
from committee import views
app_name = 'committee'
from django.contrib.auth import views as auth_views
urlpatterns = [
    path('create/event' , views.EventCreateView.as_view() , name = 'create_event') ,
    path('event/list' , views.EventListView.as_view() , name = 'event_list')
]