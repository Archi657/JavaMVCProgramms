from django.shortcuts import render
from .models import Persona
# Create your views here.
def inicio(request):
    personas = Persona.objects.all()
    return render(request,"index.html",{
        'personas': personas
    })