# Generated by Django 3.0 on 2019-12-08 02:21

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Complaint',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('folio', models.BigIntegerField(blank=True, null=True)),
                ('complaint_content', models.TextField()),
                ('name', models.CharField(max_length=100)),
                ('email', models.EmailField(max_length=254)),
                ('phone', models.CharField(max_length=10)),
                ('received_date', models.DateField(auto_now=True)),
                ('opening_date', models.DateField(null=True)),
                ('responsible_delivery_date', models.DateField(null=True)),
                ('responsible_response_date', models.DateField(null=True)),
                ('complainer_response_date', models.DateField(null=True)),
            ],
        ),
        migrations.CreateModel(
            name='ComplaintState',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='StrategicProcess',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='SubdivisionReponsible',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='ExternalRelatedComplaint',
            fields=[
                ('complaint', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, primary_key=True, related_name='external_related_complaint', serialize=False, to='api.Complaint')),
                ('relation', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='StaffComplaint',
            fields=[
                ('complaint', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, primary_key=True, related_name='staff_complaint', serialize=False, to='api.Complaint')),
                ('rfc', models.CharField(max_length=13)),
                ('department', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='StudentComplaint',
            fields=[
                ('complaint', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, primary_key=True, related_name='student_complaint', serialize=False, to='api.Complaint')),
                ('control_number', models.CharField(max_length=10)),
                ('career', models.CharField(max_length=50)),
                ('semester', models.CharField(max_length=2)),
                ('group', models.CharField(max_length=10)),
                ('turn', models.CharField(max_length=11)),
                ('classroom', models.CharField(max_length=10)),
            ],
        ),
        migrations.AddField(
            model_name='complaint',
            name='compliant_state',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='api.ComplaintState'),
        ),
        migrations.AddField(
            model_name='complaint',
            name='strategic_process',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to='api.StrategicProcess'),
        ),
        migrations.AddField(
            model_name='complaint',
            name='subdivision_responsible',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to='api.SubdivisionReponsible'),
        ),
    ]
