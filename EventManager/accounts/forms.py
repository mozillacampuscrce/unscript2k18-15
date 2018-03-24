from django.contrib.auth.forms import UserCreationForm
from django import forms

from accounts.models import User


class SignUpForm(UserCreationForm):
    class Meta:
        model = User
        fields = ('username', 'password1', 'password2' )