function [mean] = get_average(matrix)

    %orizw to sum iso me miden (athroisma stoixeiwn)
    sum = 0;

    %orizw to n iso me miden (plithos stoixeiwn)
    n = 0;

    %epanalipsi gia to prwto index tou size tou pinaka
    for i = 1 : size(matrix,1)
        %epanalipsi gia to deutero index tou size tou pinaka
        for k = 1: size(matrix,2)

            %auksanw to n kata 1 se kathe epanalipsi
            n = n + 1;

            %athroizw kathe stoixeio tou pinaka se kathe epanalipsi
            sum = sum + matrix(i,k);
        end
    end

    disp("To athroisma twn stoixeiwn einai: " + sum);
    disp("To plithos twn stoixeiwn einai: " + n);

    %apo statistiki -> o mesos oros orizetai ws to athroisma pros to
    %plithos 
    mean = sum / n;
    disp("-----------");
    disp("O mesos oros twn stoixeiwn tou pinaka einai: " + mean);
end