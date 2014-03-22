#!/bin/bash -
echo "================================================================================"
echo "| Running Maven in Back-end project"
echo "================================================================================"
cd Back-end
mvn install
echo "================================================================================"
echo "| Deploying Back-end project to Heroku"
echo "================================================================================"
cd ..
git subtree push --prefix Back-end heroku master
