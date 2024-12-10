###############################################################################
#                                   Shapes.py
###############################################################################

# Imports
from vtkmodules.all import *

def main():
    # Configuração inicial do renderizador
    ren = vtkRenderer()
    ren.SetBackground(1, 1, 1)  # Cor de fundo branca

    # Configuração da janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetWindowName('Shapes')
    renWin.SetSize(300, 300)  # Tamanho da janela

    # **Exibição da esfera**
    # Criação da esfera
    sphereSource = vtkSphereSource()
    sphereSource.SetRadius(2)  # Raio da esfera
    sphereSource.SetThetaResolution(30)  # Resolução angular
    sphereSource.SetPhiResolution(30)  # Resolução polar

    # Mapeamento da esfera
    sphereMapper = vtkPolyDataMapper()
    sphereMapper.SetInputConnection(sphereSource.GetOutputPort())

    # Ator da esfera
    sphereActor = vtkActor()
    sphereActor.SetMapper(sphereMapper)

    # Adiciona esfera ao renderizador
    ren.AddActor(sphereActor)

    # Configuração do interator para interação
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)
    renWin.Render()

    # Inicia interação com a esfera
    print("Interaja com a esfera. Pressione Enter para trocar para o cilindro.")
    iren.Start()

    # Remove a esfera ao pressionar Enter
    ren.RemoveActor(sphereActor)

    # **Exibição do cilindro**
    # Criação do cilindro
    cylinderSource = vtkCylinderSource()
    cylinderSource.SetRadius(2)  # Raio do cilindro
    cylinderSource.SetHeight(3)  # Altura do cilindro
    cylinderSource.SetResolution(50)  # Resolução angular

    # Mapeamento do cilindro
    cylinderMapper = vtkPolyDataMapper()
    cylinderMapper.SetInputConnection(cylinderSource.GetOutputPort())

    # Ator do cilindro
    cylinderActor = vtkActor()
    cylinderActor.SetMapper(cylinderMapper)

    # Adiciona cilindro ao renderizador
    ren.AddActor(cylinderActor)

    # Interação com o cilindro
    print("Interaja com o cilindro. Feche a janela para finalizar.")
    iren.Start()

if __name__ == '__main__':
    main()
