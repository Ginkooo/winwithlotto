# Generated by Django 2.1.3 on 2018-11-24 15:32

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('lotto', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='scratchtype',
            name='name',
            field=models.CharField(default='abc', max_length=30),
            preserve_default=False,
        ),
    ]