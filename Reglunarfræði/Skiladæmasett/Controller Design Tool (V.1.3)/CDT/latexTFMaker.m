function tex = latexTFMaker(sys)
% Takes in a system of type tf and returns out latex usable transer 
% function. 


[num, den] = tfdata(sys);

num = latexSOutput(cell2mat(num));
den = latexSOutput(cell2mat(den));

tex = ['$\frac{',num, '}{', den,'}$'];