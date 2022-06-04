function plot_series_min_max_avg(x, y)

    %pairnw to min stoixeio apo to dianusma xrisimopoiwntas thn get_min
    min = get_minimum(y);

    %pairnw to max stoixeio apo to dianusma xrisimopoiwntas thn get_max
    max = get_maximum(y);

    %pairnw to mean stoixeio apo to dianusma xrisimopoiwntas thn get_mean
    mean = get_mean(y);
    
    %dimiourgw to grafima me tis times twn 2 dianismatwn stous aksones x,y
    plot(x,y);

    %setarw ton titlo tou grafimatos kai ta labels stous x,y aksones
    title("Askisi 4");
    xlabel("times tou x dianismatos");
    ylabel("times tou y dianismatos");
    
    %Dimiourgw to dianisma twn min arithmwn kai emfanizw sto grafima thn
    %eutheia.
    % An px to min einai to '4' tote dimourgisei ena dianisma x stoixeiwn
    % opou x to mikos tou dianismatos x (omoiws gia max kai mean
    % gia na ksexwrizoun oi grammes tis xrwmatizw antistoixa
    
    line(x,min*ones(size(x)),'color', 'r');
    line(x,max*ones(size(x)),'color','g');
    line(x,mean*ones(size(x)),'color','m');

end