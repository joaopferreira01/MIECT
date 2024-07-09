%i)
p = sum(pXTeorica(x>=2));
printf("P(Pelo menos 2 coroas): %d\n",p);

%ii)
p = sum(pXTeorica(x<=1));
printf("P(Ate 1 coroa): %d\n",p);

%iii)
p = sum(pXTeorica(x>=1 & x<=3));
printf("P(Entre 1 e 3 coroas): %d\n",p);