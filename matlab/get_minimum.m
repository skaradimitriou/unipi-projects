function [min] = get_minimum(matrix)
    %orizw to min iso me to teleutaio stoixeio tou pinaka
    min = matrix(length(matrix));

    %epanalipsi gia to prwto index tou size apo ton pinaka
    for i = 1 : size(matrix,1)
        %epanalipsi gia to deutero index tou size apo ton pinaka
        for k = 1: size(matrix,2)

            %an to stoixeio sti thesi x,y einai mikrotero apo to min
            if(matrix(i,k) < min)

                %thetw to min iso me to stoixeio tou pinaka sti thesi x,y
               min = matrix(i,k);
            end
        end
    end

    %Emfanizw thn timh tou min meta ton ypologismo
    disp("To mikrotero stoixeio tou pinaka einai: " + min);
end