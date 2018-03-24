from django.shortcuts import render, get_object_or_404, redirect

# Create your views here.
from placement.models import CompanyForm, Company

app_name = 'placements'

def recruitment_form(request):
    if request.method == "POST":
        form = CompanyForm(request.POST)
        if form.is_valid():
            form.save(commit=True)
            return redirect('accounts:index')
    else:
        form = CompanyForm()
    return render(request, 'placements/rec_form.html', {'form': form})