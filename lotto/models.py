from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.


class User(AbstractUser):
    pass


class ScratchGroup(models.Model):
    name = models.CharField(max_length=255)


class ScratchType(models.Model):
    scratch_group = models.ForeignKey(ScratchGroup, on_delete=models.CASCADE)


class CoinBag(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    scratch_type = models.ForeignKey(ScratchType, on_delete=models.CASCADE)
    quantity = models.IntegerField(default=0)


class Scratch(models.Model):
    latitude = models.FloatField()
    longtitude = models.ForeignKey(ScratchType)
