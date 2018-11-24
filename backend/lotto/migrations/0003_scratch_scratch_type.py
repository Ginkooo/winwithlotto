# Generated by Django 2.1.3 on 2018-11-24 15:41

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('lotto', '0002_scratchtype_name'),
    ]

    operations = [
        migrations.AddField(
            model_name='scratch',
            name='scratch_type',
            field=models.ForeignKey(default=1, on_delete=django.db.models.deletion.CASCADE, to='lotto.ScratchType'),
            preserve_default=False,
        ),
    ]
