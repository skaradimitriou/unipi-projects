function [median] = get_median(vector)

    %arxika taksinomw tous arithmous tou vector pou lamvanw san parametro
    %apo ton megalitero ston mikrotero
    sortedVector = sort(vector);

    %ypologizw to plithos twn stoixeiwn tou vector
    vectorLength = length(sortedVector);
    
    %vlepw an to plithos einai artios h monos
    if(rem(vectorLength, 2) == 1 )
        %monos -> pairnw to mesaio stoixeio
        %p.x -> 10, 11, 12, 13, 15, 20, 23, 35, 41 -> diamesos = 15
        num = round(vectorLength / 2);
        median = sortedVector(num);
    else
        %artios -> athroizw ta 2 stoixeia sti mesi.
        %p.x -> 10, 11, 12, 13, 15, 20, 23, 35 -> diamesos = (13+15)/2
        num1 = round(vectorLength / 2);
        num2 = round(vectorLength / 2)+1;

        median = (sortedVector(num1) + sortedVector(num2)) /2;
    end

    disp("Η διάμεσος των στοιχείων είναι: " + median);
end