#!/bin/bash

latex bakalarka.tex && bibtex bakalarka.aux && pdflatex bakalarka.tex && rm *.aux *.bbl *.blg *.dvi *.log *.toc
