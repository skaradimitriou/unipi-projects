function [max] = get_maximum(matrix)
    %orizw to max iso me to prwto stoixeio tou pinaka
    max = matrix(1);

    %epanalipsi gia to prwto index tou size apo ton pinaka
    for i = 1 : size(matrix,1)
        %epanalipsi gia to deutero index tou size apo ton pinaka
        for k = 1: size(matrix,2)

            %an to stoixeio sti thesi x,y einai megalutero apo to max
            if(matrix(i,k) > max)

                %thetw to max iso me to stoixeio tou pinaka sti thesi x,y
               max = matrix(i,k);
            end
        end
    end

    %Emfanizw thn timh tou max meta ton ypologismo
    disp("To megalutero stoixeio tou pinaka einai: " + max);
end