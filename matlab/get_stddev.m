function [dev] = get_stddev(vector)
    %pairnw ton meso oro apo thn sunartisi get_mean ths prohgoumenhs
    %askisis
    mesosOros = get_mean(vector);

    %n einai to megethos tou pinaka
    N = length(vector);
    
    %arxikopoiw thn metavliti athroisma isi me miden
    sum = 0;
    
    %epanalipsi gia osa stoixeia exei o pinakas
    for i = 1 : N
        %se kathe epanalipsi ypologizw to (xi - μ)^2 
        xi = (vector(i) - mesosOros)^2;
        %kai to prosthetw sto sum
        sum = sum + xi;
    end

    %ypologizw thn diakimansi (apo statistiki)
    variance  = sum / (N - 1);

    %h tupiki apoklisi einai h tetragoniki riza ths diakimansis (apo
    %statistiki)
    dev = sqrt(variance);

    %ektupwsi twn apotelesmatwn sthn othoni
    disp("--------------");
    disp("Mesos Oros => " +mesosOros);
    disp("Megethos tou pinaka:" + " " + N);
    disp("Diakimansi twn stoixeiwn => " + variance);
    disp("Tupiki Apoklisi twn stoixeiwn => " + dev);
end