from django.shortcuts import render

from principal.forms import PersonaForm
from .models import Persona
# Create your views here.
def inicio(request):
    personas = Persona.objects.all()
    return render(request,"index.html",{
        'personas': personas
    })

def crearPersona(request):
    form = PersonaForm()
    contexto = {
        'form':form
    }
    return render(request, 'create.html', contexto)