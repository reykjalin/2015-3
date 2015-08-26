function programHelpMenu()
    % Opens the .pdf help maual form the help directory
  
    try     
        addpath Help;
        open('helpManual.pdf')
    catch ERROR
          disp('You must have an active .pdf reader to read the help manual');
    end