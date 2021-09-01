import discord
from discord.ext import commands

from utils.lol import Lol


bot = commands.Bot(command_prefix='!', description='League of legends bot')


@bot.event
async def on_ready():
    print('ready to start')


@bot.command()
async def help(ctx):
    await ctx.send('Hola como estas?')


@bot.command()
async def profile(ctx, summoner: str, region: str):
    lol = Lol(summoner,region)
    data = lol.greetings()

    greetings = data['greetings']
    icon_url = data['icon_url']

    emb = discord.Embed(title=greetings)
    emb.set_image(url=icon_url)
    await ctx.send(embed=emb)

@bot.command()
async def rank(ctx, self,summoner: str,region: str):
    lol=Lol(summoner,region)
    objrank= lol.rank()
    tier= objrank['tier']
    rank= objrank['rank']
    points= objrank['leaguePoints']
    w= objrank['wins']
    l= objrank['losses']

    emb = discord.Embed(title="Rankeds solo/duo", description=f'{tier}{rank}')
    emb.insert_field_at(index=0, name='LP', value=points)
    emb.insert_field_at(index=0, name='V', value=w)
    emb.insert_field_at(index=0, name='L', value=l)
    await ctx.send(embed=emb)





bot.run('ODgyMzU2NzMwNDQ3Njc5NTI4.YS6MvQ.3COUcJhShEaRmf0JtzuERSvgUFc')