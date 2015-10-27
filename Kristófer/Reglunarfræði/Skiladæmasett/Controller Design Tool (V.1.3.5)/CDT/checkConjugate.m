function val = checkConjugate(inVec)
% Checks if the input value is a legit input for input vector
% input
%           inVec  = vector of input values
% output
%           val  = boolean, true if the input value is correct false
%           otherwise

vec = inVec;
n = length(vec);

for i = 1:n
    if imag(vec(i)) ~= 0
        for k = 1:n
            if k ~= i
                if real(vec(k)) == real(vec(i))
                   if imag(vec(i)) == (-1)*imag(vec(k))
                       vec(k) = 0; vec(i) = 0;
                   end
                end
            end
        end
    else
        vec(i) = 0;
    end
end

if sum(vec) == 0
    val = 1;
else
    val = 0;
end
    