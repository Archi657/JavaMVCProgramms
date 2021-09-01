from gtts import gTTS
import os

text = "andres carne de res jijijia"

language = 'es-us'

speech = gTTS(text=text,lang = language, slow = False )

speech.save("texto.mp3")
os.system("start texto.mp3")
