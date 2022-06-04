function [cov] = get_covariance(a, b)

    %efoson a,b exoun to idio megethos, thewrw pws to N tha einai iso me to
    %megethos tou a
    N = length(a);

    %pairnw ton meso oro apo thn sunartisi get_mean ths prohgoumenhs
    %askisis gia to a,b antistoixa
    a_mean = get_mean(a);
    b_mean = get_mean(b);

    total = 0;

    %epanalipsi gia osa stoixeia exei o pinakas
    for i = 1 : N
        %se kathe epanalipsi ypologizw to (ai - μ) kai to (bi - μ) antistoixa 
        ai = (a(i) - a_mean);
        bi = (b(i) - b_mean);
        
        %prosthetw sto total to ginomeno twn ai,bi
        total = total + (ai * bi);
    end

    %ypologizw thn sundiakimansi apo ton tupo
    cov = total / (N - 1);

    %ektupwsi twn apotelesmatwn sthn othoni
    disp("--------------");
    disp("Mesos Oros A : " + a_mean);
    disp("Mesos Oros B : " + b_mean);
    disp("Megethos tou pinaka: A,B:" + " " + N);
    disp("Sundiakimansi twn stoixeiwn : " + cov);
end