from django.contrib.auth.models import AbstractUser
from django.db import models

# Create your models here.
class User(AbstractUser):
  USER_TYPE_CHOICES = (
      (1, 'student'),
      (2, 'committee'),
      (3, 'guest'),
  )

  name = models.CharField(max_length=50 , blank=True)
  user_type = models.PositiveSmallIntegerField(choices=USER_TYPE_CHOICES , default=3)