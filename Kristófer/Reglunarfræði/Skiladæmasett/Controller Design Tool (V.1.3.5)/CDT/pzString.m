function [outCell] = pzString(array)

n = length(array);
outCell = {};
for i = 1:n
    outStr = '';
    outStr = strcat(outStr, num2str(real(array(i)),3));
    if abs(imag(array(i))) > 0
        if imag(array(i)) > 0
            outStr = strcat(outStr, '+');
        else
            outStr = strcat(outStr, '-');
        end
        outStr = strcat(outStr, num2str(abs(imag(array(i))),3),'j');
    end
    outCell{1,i} = outStr;
end
        