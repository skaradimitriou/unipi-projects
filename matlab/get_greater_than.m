function [arr] = get_greater_than(matrix, n)

    %orizw ena adeio pinaka
    arr = [];

    %epanalipsi gia to prwto index tou size apo ton pinaka
    for i = 1 : size(matrix,1)
        %epanalipsi gia to deutero index tou size apo ton pinaka
        for k = 1: size(matrix,2)

            %an to stoixeio sti thesi x,y einai megalutero apo to max
            if(matrix(i,k) > n)
                %prosthetw to stoixeio tou pinaka apo thn thesi x,y sto arr
                arr(end + 1) = matrix(i,k);
            end
        end
    end
    
    disp(arr);

end