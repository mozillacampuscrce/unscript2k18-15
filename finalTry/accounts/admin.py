from django.contrib import admin
from .models import CommitteeProfile, StudentProfile, Event, User

# Register your models here.
admin.site.register(User)
admin.site.register(CommitteeProfile)
admin.site.register(StudentProfile)
admin.site.register(Event)