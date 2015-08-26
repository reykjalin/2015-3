function valStr = latexSOutput(value)

syms s;
valStr = '';

n = length(value);

% main loop runs through all;
for i = 1:n
    % If the numeric value of the constant is zero, we don't have
    % to do anything
    if value(i) == 0
        
    else
        % Assuming the constant isn't zero, special case to check if 
        % this is the first constant intot the string
        if isempty(valStr)
            % Must add negitive sign if empty
            if value(i) < 0
                valStr = strcat(valStr, '-');
            end
            % Here we have checked if this is the first value and if it 
            % is negative. Now we must check if it uses a s variable or
            % not
            if i < n
                % Assuming that the value is not the last one and has 
                % a symbolic value to it
                if abs(value(i)) ~= 1
                    valStr = strcat(valStr, num2str(abs(value(i)))...
                        ,'s^{', num2str(n-i), '}');
                else
                    valStr = strcat(valStr,'s^{', num2str(n-i), '}');
                end
            else
                % Assuming this is the last value, and therefore 
                % the only value we just add the value
                valStr = strcat(valStr, num2str(abs(value(i))));
            end
        else
            % Assuming we have covered the outliers, we make the 
            % base sample
            
            % Adding the right sign for constant
            if value(i) > 0
                valStr = strcat(valStr, '+');
            else
                valStr = strcat(valStr, '-');
            end
            
            % Adding numerical value for constant
            if (abs(value(i)) ~= 1)
               % Assuming that the constant value is not unity
               valStr = strcat(valStr, num2str(abs(value(i))));
               % checking to see if this is the last value, then no
               % symbolic s to be made
               if i < n
                   % If we are not there yet, we add a symbolic value
                   valStr = strcat(valStr, 's^{', num2str(n-i), '}');
               end
            else
                % Here the constant is one. If we are not at the
                % last value we add symbolics only
                if i == n 
                   valStr = strcat(valStr, num2str(abs(value(i)))); 
                else 
                   % Here we just add simple symbolic values
                   valStr = strcat(valStr, 's^{',...
                       num2str(abs(value(i))), '}');
                end
            end
        end
    end
end