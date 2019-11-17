using System;

                 class ejercicio26
{
        static void Main()
        {
            float[] numero = new float[3];
            float mayor = 0, menor = 0;
            int i, flag = 0,noingreso = 0

            for (i = 0; i < 3; i++)
            {
                Console.Write("{0}º número:", i + 1);
                numero[i] = float.Parse(Console.ReadLine());

                if (flag == 0)
                {
                    mayor = numero[i];
                    menor = numero[i];
                    flag = 1;
                }
                else
                {
                    if (numero[i] > mayor)
                        mayor = numero[i];
                    if (numero[i] < menor)
                        menor = numero[i];
                }
            }

            for (i = 0; i < 3; i++)
            {
                if (numero[i] != mayor && numero[i] != menor)
                {
                    Console.Write("\nEl número {0} esta entre el {1} y el {2}", numero[i], menor, mayor);
                    noingreso = 1;
                }
            }
                    if (noingreso == 0)
                    Console.Write("\nError.Hay numeros repetidos");

            Console.Read();
        }
}
