from django.shortcuts import redirect, render

from principal.forms import PersonaForm
from .models import Persona
# Create your views here.
def inicio(request):
    personas = Persona.objects.all()
    return render(request,"index.html",{
        'personas': personas
    })

def crearPersona(request):
    if request.method == 'GET':
     form = PersonaForm()
     contexto = {
        'form':form
     }
    else:
      form = PersonaForm(request.POST)
      contexto = {
        'form':form
      }
      if form.is_valid():
          form.save()
          return redirect('index')
    return render(request, 'create.html', contexto)

def editPersona(request,id):
    persona = Persona.objects.get(id = id)
    if request.method == 'GET':
        form = PersonaForm(instance = persona)
        contexto = {
            'form':form
        }
    else:
        form = PersonaForm(request.POST, instance=persona)
        contexto = {
            'form':form
        }
        if form.is_valid():
            form.save()
            return redirect('index')
    return render (request,'create.html',contexto)

def deletPersona(request,id):
    persona = Persona.objects.get(id = id)
    persona.delete()
    return redirect('index')