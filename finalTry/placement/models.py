from django.db import models

# Create your models here.
from django.forms import ModelForm


class Company(models.Model):
    name = models.CharField(max_length=50)
    email = models.EmailField(blank=True)
    criteria = models.DecimalField(max_digits=4 , decimal_places=2)
    requirement = models.TextField(max_length=260)
    def __str__(self):
        return self.name

class CompanyForm(ModelForm):
    class Meta:
        model = Company
        fields = ['name' , 'email' , 'criteria' , 'requirement']