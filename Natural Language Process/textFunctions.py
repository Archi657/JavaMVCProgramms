import binascii
import re
import string
import nltk
import os
from gtts import gTTS
from textwrap3 import wrap
from nltk.corpus import stopwords
from nltk.corpus import wordnet
from translate import  Translator
from spellchecker import SpellChecker
from nltk.corpus import wordnet
# import pprint for pprint.pprint(string,width=-1) ; pprint.pformat(text,indent=2)

def tokenization(): # import nltk
    text = "This is a sentence to try tokenization, with the library nltk. Separete points not commas"
    tokenizaton = nltk.sent_tokenize(text)
    print(tokenizaton)

def tonkennonEnglish():
    german_tokenizer = nltk.data.load('tokenizers/punkt/german.pickle')
    german_tokens = german_tokenizer.tokenize('Wie geht es Ihnen?  Gut, danke.')
    print(german_tokens)

def wordTokenization():
    text = "word tokenization, each word will get separated"
    tokens = nltk.word_tokenize(text)
    print(tokens)

def duplicateWords(): # import nlkt
    #unordered
    text = "The Sky is blue also the ocean is blue"
    tokens = nltk.word_tokenize(text)
    listWords = list(set(tokens))
    print(listWords)
    #ordered
    orderTokens = set()
    result = []
    for word in tokens:
        if word not in orderTokens:
            orderTokens.add(word)
            result.append(word)
    print(result)

def stopWords(): # import nltk ; nltk.download('stopwords')
    stops = set(stopwords.words('english'))
    words = ["There","was","a","day","where","i","used","to","study","in","the","park"]
    for word in words:
        if word not in stops:
            print(word)

def synonymsAntonyms(): # from nltk.corpus import wordnet
    synonyms = []
    for synonym in wordnet.synsets("fast"):
        for lm in synonym.lemmas():
            synonyms.append(lm.name())
    print(set(synonyms))

def lemmas(): # from nltk.corpus import wordnet as wn
    lemmas = wordnet.synset('locomotive.n.01').lemma_names()
    definition = wordnet.synset('love.n.01').definition()
    examples = wordnet.synset('good.n.01').examples()
    antonym = wordnet.lemma('fast.a.01.fast').antonyms()
    print(lemmas,definition,examples,antonym)

# corpora access


def translator(): # pip install translate ; from translate import Translator
    translator = Translator(from_lang="spanish",to_lang="german")
    translation = translator.translate("te amo")
    print(translation)

def replace():
    text = "this string has to change to word string to word"
    print(text.replace("string","word"))

def missSpelled(): # pip install pyspellchecker ; from spellchecker import SpellChecker
    spell = SpellChecker()
    text = ["ths", "txt", "si" , "wrng" , "wlitten"]
    missspelled = spell.unknown(text)
    for word in missspelled:
        print(spell.correction(word))
        print(spell.candidates(word))

def readTxt(): # read txt file and read it
    f = open("text.txt", "r")
    lines = f.readlines()
    print(lines) # ["text, \n", "..]
    string = ""
    for line in lines:
        string += line
    print(string) # text .....

def idText(): # Strings are immutable "same letter  == same memory direction"
    text = 'colombia'
    for letter in range(0, 5):
        print(text[letter], "=", id(text[letter]))

def wrapText(): # reformate pharagraphs (pip install textwrap3 ; from textwrap3 import wrap)
    text = 'In late summer 1945, guests are gathered for the wedding reception of Don Vito Corleones daughter Connie (Talia Shire) and Carlo Rizzi (Gianni Russo). Vito (Marlon Brando), the head of the Corleone Mafia family, is known to friends and associates as Godfather. He and Tom Hagen (Robert Duvall), the Corleone family lawyer, are hearing requests for favors because, according to Italian tradition, no Sicilian can refuse a request on his daughters wedding day.'
    textWrapped = wrap(text, 20)
    for i in range(len(textWrapped)):
        print(textWrapped[i])

def ascii_binary(): # import binascii
    text = "text to convert"
    binary_to_assi = binascii.b2a_uu(text)
    ascii_to_binary = binascii.a2b_uu(binary_to_assi)

def extractEmail(): # import re
    text = "Please contact us at contact@tutorialspoint.com for further information." + \
           " You can also give feedbacl at feedback@tp.com"
    emails = re.findall(r"[a-z0-9\.\-+_]+@[a-z0-9\.\-+_]+\.[a-z]+", text)
    print(emails)

def extractURL(): # import re
    text = "Now a days you can learn almost anything by just visiting http://www.google.com. But if you are completely new to computers or internet then first you need to leanr those fundamentals. Next you can visit a good e-learning site like - https://www.tutorialspoint.com to learn further on a variety of subjects."
    urls = re.findall('https?://(?:[-\w.]|(?:%[\da-fA-F]{2}))+', text)
    print(urls)

def texttoAudio(): # from gtts import gTTS ; import os
    text = "hello, this is text to audio"
    language = 'es-us'
    speech = gTTS(text=text, lang=language, slow=False)
    speech.save("texto.mp3")
    os.system("start texto.mp3")

def captlize(): # import string
    text = "TEXT TO use as example"
    print(string.capwords(text)) # Text To Use As Example






