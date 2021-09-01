import requests
from requests.models import Response


class LolSettings:
    def __init__(self, summoner, region):
        self.summoner = summoner
        self.region = region
        self.headers = {'X-Riot-Token': 'api'}

    def start(self):
        url = f'https://la1.api.riotgames.com/lol/summoner/v4/summoners/by-name/{self.summoner}'
        response = requests.get(url, headers=self.headers)
        return response.json()

class Lol(LolSettings):
    def __init__(self, summoner, region):
        super().__init__(summoner, region)
    
    def greetings(self):
        summoner = self.start()
        name = summoner['name']
        lvl = summoner['summonerLevel']
        icon_id = summoner['profileIconId']

        greetings = f'Saludos invocador {name}, lvl {lvl} uwu.'
        icon_url  = f'https://ddragon.leagueoflegends.com/cdn/11.6.1/img/profileicon/{icon_id}.png'
        return {'greetings': greetings, 'icon_url': icon_url}

    def rank(self):
        summoner = self.start()
        summoner_id = summoner['id']
        name = summoner['name']
        url = f'https://la1.api.riotgames.com/lol/league/v4/entries/by-summoner/{summoner_id}'
        response = requests.get(url,headers=self.headers)
        return response.json(0)
    
    
