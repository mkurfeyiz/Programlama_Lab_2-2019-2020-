#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

// 170201083 - Muhammed Kurfeyiz

void rgbDosyayiOku_SayilariAl(FILE *fp,char satir[],double x[],double y[],double z[],int rgb[])
{
    fp=fopen("testVerileri.nkt","r");
    double sayilar[53];
    char *ayrilan;
    int sayac=0,i=0;
    while(fgets(satir,250,fp))
    {
        //printf("%s",satir);//15.(14) indexte nokta sayisi var.18.(17) indexte almak istedigim sayilar basliyor.(rgb dosyalari icin)
        ayrilan=strtok(satir," ");
        while(ayrilan!=NULL)
        {
            sayilar[i]=atof(ayrilan);
            i++;
            ayrilan=strtok(NULL," ");
        }
        sayac++;
    }
    if((sayac-5)!=sayilar[14])
    {
        printf("Nokta sayisi esit degil!\n");
        return 0;
    }
    int j,m=0,l=0;//rgblerde 17. indexten sonra sayilar geliyo rgb olmayanlarda da 14. indexten sonra gelir.
    double tumNoktalar[(sizeof(sayilar)/8)-17];
    for(j=0; j<((sizeof(sayilar)/8)-17); j++)
    {
        tumNoktalar[j]=sayilar[j+17];
    }
    /*for(j=0; j<(sizeof(sayilar)/8); j++)
    {
        printf("%f \t",sayilar[j]);
    }
    printf("\n");*/

    for(j=0; j<(sizeof(tumNoktalar)/8); j++)
    {
        if(j%3==0 && j%2!=0)
        {
            rgb[m]=tumNoktalar[j];
            rgb[m+1]=tumNoktalar[j+1];
            rgb[m+2]=tumNoktalar[j+2];
            m=m+3;
            j+=2;
        }
        else
        {
            x[l]=tumNoktalar[j];
            y[l]=tumNoktalar[j+1];
            z[l]=tumNoktalar[j+2];
            l++;
            j+=2;
        }
    }
    /*printf("\n");
    for(j=0; j<6; j++)
    {
        printf("%f %f %f\n",x[j],y[j],z[j]);//SON 2 for DONGUSU KONTROL AMACLI KONSOLA YAZDIRIYORUZ.
    }
    printf("\n");
    for(j=0; j<18; j++)
    {
        printf("%d \t",rgb[j]);
    }
    printf("\n");*/
    fclose(fp);
}

void dosyayiOku_SayilariAl(FILE *fp,char satir[],double x[],double y[],double z[])
{
    fp=fopen("problemli.nkt.txt","r");
    double sayilar[32];
    char *ayrilan;
    int sayac=0,i=0;
    while(fgets(satir,250,fp))
    {
        //printf("%s",satir);//15.(14) indexte nokta sayisi var.18.(17) indexte almak istedigim sayilar basliyor.(rgb dosyalari icin)
        ayrilan=strtok(satir," ");
        while(ayrilan!=NULL)
        {
            sayilar[i]=atof(ayrilan);
            i++;
            ayrilan=strtok(NULL," ");
        }
        sayac++;
    }
    if((sayac-5)!=sayilar[11])
    {
        printf("Nokta sayisi esit degil!\n");
        return 0;
    }
    int j,l=0;//rgblerde 17. indexten sonra sayilar geliyo rgb olmayanlarda da 14. indexten sonra gelir.
    double tumNoktalar[(sizeof(sayilar)/8)-17];
    for(j=0; j<((sizeof(sayilar)/8)-17); j++)
    {
        tumNoktalar[j]=sayilar[j+14];
    }
    /*for(j=0; j<(sizeof(sayilar)/8); j++)
    {
        printf("%f \t",sayilar[j]);
    }
    printf("\n");*/

    for(j=0; j<(sizeof(tumNoktalar)/8); j++)
    {
        x[l]=tumNoktalar[j];
        y[l]=tumNoktalar[j+1];
        z[l]=tumNoktalar[j+2];
        l++;
        j+=2;
    }
    /*printf("\n");
    for(j=0; j<6; j++)
    {
        printf("%f %f %f\n",x[j],y[j],z[j]);//SON 2 for DONGUSU KONTROL AMACLI KONSOLA YAZDIRIYORUZ.
    }
    printf("\n");*/
    fclose(fp);
}

double noktalarinOrtalamasi(FILE *fp,double x[],double y[],double z[],int boyut)
{
    int i,sayac=0;
    double ortalama,toplam=0;
    double fark[boyut];
    fprintf(fp,"\n----SECIM 4----\n");
    for(i=0; i<boyut; i++) // 127,844449876224 10,053376538436 568,462469687401
    {
        fark[sayac]=sqrt(pow((x[i+1]-x[i]),2)+pow((y[i+1]-y[i]),2)+pow((z[i+1]-z[i]),2));
        sayac++;
    }
    for(i=0; i<sayac; i++)
    {
        toplam=toplam+fark[i];
    }
    ortalama=toplam/(sayac);
    fprintf(fp,"Noktalarin ortalamasi : %f\n",ortalama);
    return ortalama;
}

void enYakin_UzakNokta(FILE *fp,double x[],double y[],double z[],int boyut)
{
    int i,j,sayac=0;
    double minFark=1000.0,maxFark=0.0,fark[50];
    double xMin1,yMin1,zMin1,xMax1,yMax1,zMax1,xMin2,yMin2,zMin2,xMax2,yMax2,zMax2;
    fprintf(fp,"\n----SECIM 1----\n");
    for(i=0;i<boyut;i++)
    {
        for(j=1;j<boyut;j++)
        {
            fark[sayac]=sqrt(pow((x[j]-x[i]),2)+pow((y[j]-y[i]),2)+pow((z[j]-z[i]),2));
            sayac++;
            if(fark[j-1]>maxFark)
            {
                maxFark=fark[j-1];
                xMax1=x[i]; xMax2=x[j];
                yMax1=y[i]; yMax2=y[j];
                zMax1=z[i]; zMax2=z[j];
            }
            else if(fark[j-1]<minFark)
            {
                minFark=fark[j-1];
                xMin1=x[i]; xMin2=x[j];
                yMin1=y[i]; yMin2=y[j];
                zMin1=z[i]; zMin2=z[j];
            }
        }
    }
    fprintf(fp,"En yakin noktalar : (%f,%f,%f) (%f,%f,%f)\n",xMin1,yMin1,zMin1,xMin2,yMin2,zMin2);
    fprintf(fp,"En uzak noktalar : (%f,%f,%f) (%f,%f,%f)\n",xMax1,yMax1,zMax1,xMax2,yMax2,zMax2);
    printf("En yakin noktalar : (%f,%f,%f) (%f,%f,%f)\n",xMin1,yMin1,zMin1,xMin2,yMin2,zMin2);
    printf("En uzak noktalar : (%f,%f,%f) (%f,%f,%f)\n",xMax1,yMax1,zMax1,xMax2,yMax2,zMax2);
}

void kureOlustur(FILE *fp,double x[],double y[],double z[],int boyut)
{
    int cx,cy,cz,r,i;
    double uzaklik=0;
    fprintf(fp,"\n----SECIM 3----\n");
    printf("\nKurenin merkezi icin x koordinati giriniz : ");
    scanf("%d",&cx);
    fprintf(fp,"\nx koordinati : %d",cx);
    printf("\nKurenin merkezi icin y koordinati giriniz : ");
    scanf("%d",&cy);
    fprintf(fp,"\ny koordinati : %d",cy);
    printf("\nKurenin merkezi icin z koordinati giriniz : ");
    scanf("%d",&cz);
    fprintf(fp,"\nz koordinati : %d",cz);
    printf("\nKurenin yaricap uzunlugunu giriniz : ");
    scanf("%d",&r);
    fprintf(fp,"\nKurenin yaricap uzunlugunu : %d",r);
    printf("\nKurenin icinde kalan noktalar : \n");
    fprintf(fp,"\nKurenin icinde kalan noktalar : \n");
    for(i=0; i<boyut; i++)
    {
        uzaklik = sqrt(pow((x[i]-cx),2)+pow((y[i]-cy),2)+pow((z[i]-cz),2));
        if(uzaklik<=r)
        {
            printf("%f %f %f \n",x[i],y[i],z[i]);
            fprintf(fp,"%f %f %f \n",x[i],y[i],z[i]);
        }
    }
}

void kupOlustur(FILE *fp,double x1[],double y1[],double z1[],int boyut,double *x,double *y,double *z)
{
    int i,j;
    double tempx,tempy,tempz;
    double x2[boyut],y2[boyut],z2[boyut];
    for(i=0;i<boyut;i++)
    {
        x2[i]=x1[i];
        y2[i]=y1[i];
        z2[i]=z1[i];
    }
    fprintf(fp,"\n----SECIM 2----\n");
    for(i=0; i<=boyut; i++)
    {
        for(j=boyut; j>i; j--)
        {
            if(z2[j-1]<z2[j-1-1])//z icin
            {
                tempz=z2[j-1-1];
                z2[j-1-1]=z2[j-1];
                z2[j-1]=tempz;
            }
            if(y2[j-1]<y2[j-1-1])//y icin
            {
                tempy=y2[j-1-1];
                y2[j-1-1]=y2[j-1];
                y2[j-1]=tempy;
            }
            if(x2[j-1]<x2[j-1-1])//x icin
            {
                tempx=x2[j-1-1];
                x2[j-1-1]=x2[j-1];
                x2[j-1]=tempx;
            }
        }
    }
    x=(int)x2[0]+rand()%(int)(x2[boyut-1]);
    y=(int)y2[0]+rand()%(int)(y2[boyut-1]);
    z=(int)z2[0]+rand()%(int)(z2[boyut-1]);
    printf("Olusan kupun koordinatlari x : %d y : %d z : %d\n",x,y,z);
    fprintf(fp,"Olusan kupun koordinatlari x : %d y : %d z : %d\n",x,y,z);
}

int main()
{
    FILE *file,*fileWrite;
    int rgbDegerleri[18];
    double xyzNoktalari[6],*x,*y,*z;
    double x1[6],y1[6],z1[6];
    char rgbDosya[250],normalDosya[250];
    rgbDosyayiOku_SayilariAl(file,rgbDosya,x1,y1,z1,rgbDegerleri);
    fileWrite=fopen("output.nkt","w");
    //dosyayiOku_SayilariAl(file,normalDosya,x1,y1,z1);
    int secim;
    printf("Secimlerinize gore bazi islemler icra edilecektir.\n");
    printf("1 ---> Birbirine en yakin ve en uzak olan noktalari bulur.\n");
    printf("2 ---> Tum noktalari icinde barindiran bir kupun merkez koordinatlarini yazdirir.\n");
    printf("3 ---> Kullanicidan alinan degerlere gore bir kure olusturulur ve kure icinde kalan noktalar yazdirilir.\n");
    printf("4 ---> Noktalar arasindaki farkin ortalamasini alir.\n");
    printf("0 ---> Programi sonlandirir.\n");
    printf("Yapmak istediginiz islemi seciniz <1-4>: ");
    scanf("%d",&secim);
    while(secim!=0)
    {
        switch(secim)
        {
        case 1:
            enYakin_UzakNokta(fileWrite,x1,y1,z1,sizeof(x1)/8);
            printf("-------------------------------------------------\n");
            break;
        case 2:
            kupOlustur(fileWrite,x1,y1,z1,sizeof(x1)/8,&x,&y,&z);
            printf("-------------------------------------------------\n");
            break;
        case 3:
            kureOlustur(fileWrite,x1,y1,z1,sizeof(x1)/8);
            printf("-------------------------------------------------\n");
            break;
        case 4:
            printf("Noktalarin ortalamasi : %f\n",noktalarinOrtalamasi(fileWrite,x1,y1,z1,sizeof(x1)/8));
            printf("-------------------------------------------------\n");
            break;
        default:
            printf("Yanlis deger girdiniz!\n");
            break;
        }
        printf("Baska islem yapmak icin 1-4 arasinda deger giriniz (Cikmak icin 0 giriniz): ");
        scanf("%d",&secim);
    }
    printf("Program kapatildi!");
    fclose(fileWrite);
    return 0;
}
