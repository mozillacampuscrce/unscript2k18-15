from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView, ListView
from .forms import CreateEventForm
from accounts.models import Event


class EventCreateView(CreateView):
    model = Event
    template_name = 'ALL HTML FILES/event_create.html'
    form_class = CreateEventForm

class EventListView(ListView):
    model = Event
    template_name = 'ALL HTML FILES/event_list.html'