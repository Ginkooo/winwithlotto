from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.


class User(AbstractUser):
    pass


class ScratchGroup(models.Model):
    name = models.CharField(max_length=255)

    def __str__(self):
        return f'Scratch group: {self.name}'


class Award(models.Model):
    amount = models.IntegerField()

    def __str__(self):
        return f'Award: {self.amount} PLN'


class ScratchType(models.Model):
    name = models.CharField(max_length=30)
    scratch_group = models.ForeignKey(ScratchGroup, on_delete=models.CASCADE)
    awards = models.ManyToManyField(Award)

    def __str__(self):
        return f'ScratchType: {self.name}'


class CoinBag(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    scratch_group = models.ForeignKey(ScratchGroup, on_delete=models.CASCADE)
    quantity = models.IntegerField(default=0)

    def __str__(self):
        return f'Coin bag of {self.user} with {self.quantity} coins for stratch group {self.scratch_group}'


class Scratch(models.Model):
    latitude = models.FloatField()
    longtitude = models.FloatField()
    scratch_type = models.ForeignKey(ScratchType, on_delete=models.CASCADE)
